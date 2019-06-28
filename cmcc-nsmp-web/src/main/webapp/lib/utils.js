function changeComeFrom(data) {
    if(data==0){
        return "系统内置"
    }else{
        return "自定义"
    }
}
/*数据类型转化*/
function dataChange(data) {
    if(data=="N"){
        return "数字类型"
    }
    if(data=="D"){
        return "日期类型"
    }
    if(data=="S"){
        return "字符"
    }
    if(data=="E"){
        return "枚举"
    }
    if(data=="L"){
        return "列表类型"
    }
    if(data=="P"){
        return "密码"
    }
}
/*业务分类*/
function bsTypeToString(bsType){
    //switch ()
    //if
    if(bsType==1){
        return "通用属性";
    }else if(bsType == 2){
        return "硬件属性";
    }else if(bsType == 3){
        return "软件属性";
    }else if(bsType == 4){
        return "登录属性";
    }else{
        return "自定义属性";
    }
}
/*采集方式转化方法
* 人工录入、登录采集、远程扫描*/
function change(data) {
    if(data==001){
        return "远程扫描";
    }
    if(data==10){
        return "登录采集";
    }
    if(data==100){
        return "人工录入";
    }
    if(data==110){
        return "人工录入、登录采集";
    }
    if(data==101){
        return "人工录入、远程扫描"
    }
    if(data==11){
        return "登录采集、远程扫描"
    }
    if(data==111){
        return "人工录入、登录采集、远程扫描"
    }
}
/* * 时间格式化工具
* 把Long类型的1527672756454日期还原yyyy-MM-dd 00:00:00格式日期
*/
function datetimeFormat(longTypeDate){
    var dateTypeDate = "";
    var date = new Date();
    date.setTime(longTypeDate);
    dateTypeDate += date.getFullYear(); //年
    dateTypeDate += "-" + getMonth(date); //月
    dateTypeDate += "-" + getDay(date); //日
    dateTypeDate += " " + getHours(date); //时
    dateTypeDate += ":" + getMinutes(date);  //分
    dateTypeDate += ":" + getSeconds(date);  //分
    return dateTypeDate;
}
/*
 * 时间格式化工具
 * 把Long类型的1527672756454日期还原yyyy-MM-dd格式日期
 */
function dateFormat(longTypeDate){
    var dateTypeDate = "";
    var date = new Date();
    date.setTime(longTypeDate);
    dateTypeDate += date.getFullYear(); //年
    dateTypeDate += "-" + getMonth(date); //月
    dateTypeDate += "-" + getDay(date); //日
    return dateTypeDate;
}
//返回 01-12 的月份值
function getMonth(date){
    var month = "";
    month = date.getMonth() + 1; //getMonth()得到的月份是0-11
    if(month<10){
        month = "0" + month;
    }
    return month;
}
//返回01-30的日期
function getDay(date){
    var day = "";
    day = date.getDate();
    if(day<10){
        day = "0" + day;
    }
    return day;
}
//小时
function getHours(date){
    var hours = "";
    hours = date.getHours();
    if(hours<10){
        hours = "0" + hours;
    }
    return hours;
}
//分
function getMinutes(date){
    var minute = "";
    minute = date.getMinutes();
    if(minute<10){
        minute = "0" + minute;
    }
    return minute;
}
//秒
function getSeconds(date){
    var second = "";
    second = date.getSeconds();
    if(second<10){
        second = "0" + second;
    }
    return second;
}
function bound_asset_type_prop(title,url,w,h){
    layer_show(title,url,w,h);
}
function isView(data) {
    if(data==1){
        return "显示";
    }
    return "不显示";
}
function needValue(data) {
    if(data==1){
        return "必填";
    }
    return "非必填";
}


