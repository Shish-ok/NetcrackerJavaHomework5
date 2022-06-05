function ready () {
    let input = document.querySelector('.input-file');
    input.addEventListener('change', function (e) {
        console.log(input.innerHTML);
    });
}

document.addEventListener("DOMContentLoaded", ready);