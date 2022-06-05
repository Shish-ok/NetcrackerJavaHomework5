function ready () {
    let input = document.querySelector('.input-file');

    input.addEventListener('change', function (e) {
        let lable = input.nextElementSibling;
        label.innerHTML = input.innerHTML;
    });
}

document.addEventListener("DOMContentLoaded", ready);