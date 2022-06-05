function ready () {
    let input = document.querySelector('.input-file');
    let lable = input.nextElementSibling;

    input.addEventListener('change', function (e) {
        label.innerHTML = input.innerHTML;
    });
}

document.addEventListener("DOMContentLoaded", ready);