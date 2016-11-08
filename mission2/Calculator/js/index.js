//计算主函数
function calculate() {
    var num1 = Number(document.getElementById("input1").value);
    var num2 = Number(document.getElementById("input2").value);
    var operator = String(document.getElementById("select").value);
    var result = 0;
    showResult("");
    if(!checkInput()){
        return false;
    }
    //除法时对除数为0的处理
    if (operator == '/' && num2 == 0) {
        errorMessage("除数不能为0，请重新输入！")
        return false;
    }
    switch (operator) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            result = num1 / num2;
            break;
        case '%':
            result = num1 % num2;
            break;
        default:
            break;
    }
    showResult(result);
}

//检查输入是否合法
function checkInput() {
    var input1 = document.getElementById("input1");
    var input2 = document.getElementById("input2");
    var num1 = Number(input1.value);
    var num2 = Number(input2.value);
    if (isNaN(num1) || (input2 != null && isNaN(num2))) {
            errorMessage("请输入数字类型！");
            return false;
        }
        return true;
    }
    //输出错误信息
    function errorMessage(msg) {
        document.getElementById("note").innerHTML = String(msg);
        setTimeout(function() {
                document.getElementById("note").innerHTML = "";
            },
            4000)
    }
    //输出结果
    function showResult(result) {
        document.getElementById("result").innerHTML = result;
    }
