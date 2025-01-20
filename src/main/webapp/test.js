// const arr = [0, 2, 1, 5, 9, 3, 4, 6, 7, 8]
//
// for (let i = 0; i < arr.length; i++) {
//     for (let j = 0; j < arr.length - 1; j++) {
//         if(arr[j] > arr[j+1]){
//             const tmp = arr[j]
//             arr[j] = arr[j+1]
//             arr[j+1] = tmp
//         }
//     }
// }
//
// window.alert(arr)
// console.info("")

let a=10
// a="Hello world"
// console.info(a)

// function f(a)
// {
//     console.info("函数测试")
//     console.info(a)
//     return a
// }
// f(a)


function f() {
    window.alert("你输入了一个字符")
}

function checkIllegal(e) {
    if(e.value.length < 6) {
        e.setAttribute("class", "illegal-pwd")   
    }else {
        e.removeAttribute("class")
    }
}


function http() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://www.baidu.com');
    xhr.send();
}


function updateTime() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("time").innerText = xhr.responseText
        }
    };
    xhr.open('GET', 'time', true);
    xhr.send();
}