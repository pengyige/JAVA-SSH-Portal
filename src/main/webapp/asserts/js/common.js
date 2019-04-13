/**全局变量*/
var LOCATION_WEB_SOCKET = "ws://127.0.0.1:8080/portal/locationWebSocket.websocket";

/************提升框架************/
/***
 * 初始提示框
 */
function initMessenge() {
    $._messengerDefaults = {
        extraClasses: 'messenger-fixed messenger-theme-ice messenger-on-top'
    }
}

/**
 * 发送网络请求之前处理
 */
function sendRequestBeforeHandle() {
    $("#waitDialog").modal();
}

/***
 * 网络请求失败处理
 */
function sendRequestFailHandle() {
        $("#waitDialog").modal('hide');
        $.globalMessenger().post({
            message: "操作失败",//提示信息
            type: 'error',//消息类型。error、info、success
            hideAfter: 5,//多长时间消失
            showCloseButton:true,//是否显示关闭按钮
            hideOnNavigate: true //是否隐藏导航

        });
}

/*********Bootstrap-table字段格式化*********/
/**
 * 连接字段格式化
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function linkFormatter(value, row, index) {
    return "<a href='" + value + "' title='单击打开连接' target='_blank'>" + value + "</a>";
}

/**
 * Email字段格式化
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function emailFormatter(value, row, index) {
    return "<a href='mailto:" + value + "' title='单击打开连接'>" + value + "</a>";
}

/**
 * 性别字段格式化
 * @param value
 * @returns {string}
 */
function sexFormatter(value) {
    if (value == "0") { color = 'Red';
        value = '女'
    }
    else if (value == "1") { color = 'Green';
        value = '男'
    }
    else { color = 'Yellow'; }

    return '<div  style="color: ' + color + '">' + value + '</div>';
}


/*********百度地图*********/
/**
 * 自动完成
 */
function loadMapAutoCommplete(inputId) {
    var ac = new BMap.Autocomplete({
        "input":inputId
    });
}