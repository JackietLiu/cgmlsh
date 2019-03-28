package configtools;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Update by internetroot on 2014-09-06.
 */
public class export2insert {
     
    public static String execute(String thefile, String sqlscript,String dbtype,String connstr,String username,String pwd,String tablename) throws Exception {
        List<String> listSQL = new ArrayList<String>();
        
        Connection conn = null;
        Statement sm = null;
        String driver="";
        if(dbtype.equalsIgnoreCase("mysql"))
        {
        	driver="com.mysql.jdbc.Driver";
        }
        	
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(connstr, username, pwd);
            sm = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        List<String> thelist=  getColumnNameAndColumeValue(sm,sqlscript,tablename);
      //  executeSQL(conn, sm, listSQL, tableList);//执行sql并拼装
        createFile(thefile,thelist);//创建文件
        return null;
    }

    /**
     * 创建insertsql.txt并导出数据
     */
    private static void createFile(String filePath, List<String> thelist) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建文件名失败！！");
                e.printStackTrace();
            }
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            if (thelist.size() > 0) {
                for (int i = 0; i < thelist.size(); i++) {
                    bw.append(thelist.get(i));
                    bw.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取列名和列值
     *
     * @param sm
     * @param listSQL
     * @param rs
     * @return
     * @throws java.sql.SQLException
     */
    private static  List<String> getColumnNameAndColumeValue(Statement sm,
              String sql, String tablename ) throws SQLException {
        
    	 List<String> insertList = new ArrayList<String>();
            ResultSet rs = sm.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                StringBuffer ColumnName = new StringBuffer();
                StringBuffer ColumnValue = new StringBuffer();
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    if (i == columnCount) {
                        ColumnName.append(rsmd.getColumnName(i));
                        if (Types.CHAR == rsmd.getColumnType(i) || Types.VARCHAR == rsmd.getColumnType(i)
                                || Types.LONGVARCHAR == rsmd.getColumnType(i)) {
                            if (value == null) {
                                ColumnValue.append("null");
                            } else {
                                ColumnValue.append("'").append(value).append("'");
                            }
                        } else if (Types.SMALLINT == rsmd.getColumnType(i) || Types.INTEGER == rsmd.getColumnType(i)
                                || Types.BIGINT == rsmd.getColumnType(i) || Types.FLOAT == rsmd.getColumnType(i)
                                || Types.DOUBLE == rsmd.getColumnType(i) || Types.NUMERIC == rsmd.getColumnType(i)
                                || Types.DECIMAL == rsmd.getColumnType(i)) {
                            if (value == null) {
                                ColumnValue.append("null");
                            } else {
                                ColumnValue.append(value);
                            }
                        } else if (Types.DATE == rsmd.getColumnType(i) || Types.TIME == rsmd.getColumnType(i)
                                || Types.TIMESTAMP == rsmd.getColumnType(i)) {
                            if (value == null) {
                                ColumnValue.append("null");
                            } else {
                                ColumnValue.append("timestamp'").append(value).append("'");
                            }
                        } else {
                            if (value == null) {
                                ColumnValue.append("null");
                            } else {
                                ColumnValue.append(value);
                            }
                        }
                    } else {
                        ColumnName.append(rsmd.getColumnName(i) + ",");
                        if (Types.CHAR == rsmd.getColumnType(i) || Types.VARCHAR == rsmd.getColumnType(i)
                                || Types.LONGVARCHAR == rsmd.getColumnType(i)) {
                            if (value == null) {
                                ColumnValue.append("null,");
                            } else {
                                ColumnValue.append("'").append(value).append("',");
                            }
                        } else if (Types.SMALLINT == rsmd.getColumnType(i) || Types.INTEGER == rsmd.getColumnType(i)
                                || Types.BIGINT == rsmd.getColumnType(i) || Types.FLOAT == rsmd.getColumnType(i)
                                || Types.DOUBLE == rsmd.getColumnType(i) || Types.NUMERIC == rsmd.getColumnType(i)
                                || Types.DECIMAL == rsmd.getColumnType(i)) {
                            if (value == null) {
                                ColumnValue.append("null,");
                            } else {
                                ColumnValue.append(value).append(",");
                            }
                        } else if (Types.DATE == rsmd.getColumnType(i) || Types.TIME == rsmd.getColumnType(i)
                                || Types.TIMESTAMP == rsmd.getColumnType(i)) {
                            if (value == null) {
                                ColumnValue.append("null,");
                            } else {
                                ColumnValue.append("timestamp'").append(value).append("',");
                            }
                        } else {
                            if (value == null) {
                                ColumnValue.append("null,");
                            } else {
                                ColumnValue.append(value).append(",");
                            }
                        }
                    }
                }
                //System.out.println(ColumnName.toString());
                //System.out.println(ColumnValue.toString());
               
                
                StringBuffer insertSQL = new StringBuffer();
                insertSQL.append("INSERT INTO ").append(" ").append(tablename).append("(").append(ColumnName.toString())
                        .append(")").append(" values ").append("(").append(ColumnValue.toString()).append(");");
                insertList.add(insertSQL.toString());
            }
       
        return insertList;
    }

   
    public static void main(String[] args) throws Exception {
        

       

    }
}

