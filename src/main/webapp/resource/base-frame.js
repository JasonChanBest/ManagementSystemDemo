function loadMenu() {
    $.ajax({
        url:"/menu/rootMenus.do",
        dataType:"json",
        success:function(data){
            console.log(JSON.stringify(data));
            var nodes = [];
            getTree(nodes, data);
            console.log(JSON.stringify(nodes));
            $('#menu').treeview({data:nodes,enableLinks:true});
        },
        error:function(){

        }
    });
}

function getTree(nodes, data) {
    if($.isArray(data)) {
        for(var i = 0; i < data.length; ++i) {
            getTree(nodes, data[i]);
        }
    } else {
        var node = {};
        nodes[nodes.length] = node;
        node.text = data.name;
        node.href = data.url == '' ? 'javascript:void(0);' : data.url;
        if(data.children.length > 0) {
            var _nodes = [];
            node.nodes = _nodes;
            getTree(_nodes, data.children);
        }
    }
}