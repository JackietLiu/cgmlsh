

function ifselect_multi_row(id,dgtype,msg){
    if(dgtype=="bootstrap-table"){
        $.messager.alert('提信息示',msg,"info");
    }

    if (dgtype=="easyui"){
        $.messager.alert('提信息示',msg,"info");
    }
}