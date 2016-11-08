//保存前一个运算数
var num = 0;
//保存中间计算结果
var result = 0;
//保存当前屏幕上的运算数
var numshow = "0";
//输入状态标志，当点击功能键时，将其置1，之后再点击数字键区时根据改状态选择清除原来的屏幕内容
var operate = 0;
//计算状态标志，1，2，3，4，5，6，7，8，9分别代表+ - * / % sin cos tan cot九种运算
var calcul = 0;
//防止重复按键的标志，比如按了两次+ 通过该标志只执行一次加运算
var quit = 0;
//按数字键的操作
function command(num) {
    //获取当前屏幕值
    var str = String(document.calculator.numScreen.value);
    //如果是0或者上一个按键是功能键，则返回空，否则返回屏幕上的字符串
    if (str == "0" || operate != 0) {
        str = "";
    }
    //在现有的显示后面添加数字
    str = str + String(num);
    //刷新显示 
    document.calculator.numScreen.value = str;
    //重置输入状态为0保证后面可以输入数字
    operate = 0;
    //重置防止重复按键的标志,使功能键可以生效
    quit = 0;
}
//末尾加两个0
function dzero() {
    var str = String(document.calculator.numScreen.value);
    //如果是0或者上一个按键是功能键，那么返回0，否则后面加00
    if (str == "0" || operate != 0) {
        str = "0";
    } else {
        str = str + "00";
    }
    document.calculator.numScreen.value = str;
    operate = 0;
}
//加小数点
function dot() {
    var str = String(document.calculator.numScreen.value);
    //如果上一个按键是功能键，那么返回0，否则返回屏幕上字符串
    if (operate != 0) {
        str = "0";
    }
    //如果已经有了小数点，直接返回
    for (i = 0; i < str.length; i++) {
        if (str.charAt(i) == '.') return false;
    }
    str = str + ".";
    document.calculator.numScreen.value = str;
    operate = 0;
}
//退格
function del() {
    var str = String(document.calculator.numScreen.value);
    str = str.substr(0, str.length - 1);
    if (str == "") {
        str = "0";
    }
    document.calculator.numScreen.value = str;
}
//清屏
function clearScreen() {
    num = 0;
    result = 0;
    numshow = "0";
    document.calculator.numScreen.value = "0";
}
//加法 
function plus() {
    //调用计算函数 
    calculate();
    //更改输入状态 
    operate = 1;
    //更改计算状态为加 
    calcul = 1;
}

//减法 
function minus() {
    calculate();
    operate = 1;
    calcul = 2;
}
//乘法
function times() {
    calculate();
    operate = 1;
    calcul = 3;
}
//除法 
function divide() {
    calculate();
    operate = 1;
    calcul = 4;
}
//求余 
function percent() {
    calculate();
    operate = 1;
    calcul = 5;
}
//正弦
function sin() {
    calcul = 6;
    trigo();
    operate = 1;

}
//余弦
function cos() {
    calcul = 7;
    trigo();
    operate = 1;
}
//正切
function tan() {
    calcul = 8;
    trigo();
    operate = 1;
}
//余切
function cot() {
    calcul = 9;
    trigo();
    operate = 1;
}
//等于
function equal() {
    calculate();
    operate = 1;
    num = 0;
    result = 0;
    numshow = "0";
    quit = 0;
}
//二则计算
function calculate() {
    //取屏幕上的值作为运算数
    numshow = Number(document.calculator.numScreen.value);
    //判断前一个运算数是否为零以及防重复按键的状态 
    if (num != 0 && quit != 1) {
        //判断要输入状态 
        switch (calcul) {
            case 1:
                result = num + numshow;
                break;
            case 2:
                result = num - numshow;
                break;
            case 3:
                result = num * numshow;
                break;
            case 4:
                if (numshow != 0) {
                    result = num / numshow;
                } else {
                    document.getElementById("note").innerHTML = "被除数不能为零！";
                    clearScreen();
                    setTimeout(clearnote, 4000)
                }
                break;
            case 5:
                result = num % numshow;
                break;
        }
        //避免重复按键 
        quit = 1; 
    } else {
        result = numshow;
    }
    numshow = String(result);
    //显示结果长度最长为8
    document.calculator.numScreen.value = numshow.substr(0, 8);
    //存储当前值作为前一个运算数
    num = result; 
}
//三角运算
function trigo() {
    //取屏幕上的值作为运算数
    numshow = Number(document.calculator.numScreen.value); 
    //三角函数运算不受上一个运算数的控制
    switch (calcul) { 
        case 6:
            //保证一定的精度
            result = Math.round(Math.sin(numshow / 180 * Math.PI) * 100000000) / 100000000;
            break;
        case 7:
            result = Math.round(Math.cos(numshow / 180 * Math.PI) * 100000000) / 100000000;
            break;
        case 8:
            result = Math.round(Math.tan(numshow / 180 * Math.PI) * 100000000) / 100000000;
            break;
        case 9:
            if (Math.tan(numshow) != 0) {
                result = 1 / Math.tan(numshow);
            } else {
                document.getElementById("note").innerHTML = "Cot 0 不存在！";
                setTimeout(clearnote, 4000)
            }
            break;
    }
    numshow = String(result);
    document.calculator.numScreen.value = numshow.substr(0, 8);
}
//清空提示 
function clearnote() {
    document.getElementById("note").innerHTML = "";
}
