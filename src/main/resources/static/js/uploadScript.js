function ready () {
    var input = document.querySelector('.input-file');
    var label = input.nextElementSibling
    input.addEventListener('change', function (e) {
        label.querySelector('span').innerHTML = e.target.value;
    });
}

document.addEventListener("DOMContentLoaded", ready);