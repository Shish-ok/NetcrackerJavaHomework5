function ready () {
    let input = document.querySelector('.input-file');
    let lable = input.nextElementSibling;

    input.addEventListener('change', function (e) {
        label.innerHTML = input.innerHTML;
    });
}

document.addEventListener("DOMContentLoaded", ready);

var inputs = document.querySelectorAll('.input-file');
Array.prototype.forEach.call(inputs, function (input) {
    var label = input.nextElementSibling;
    var labelVal = label.innerHTML;

    input.addEventListener('change', function (e) {
        var fileName = '';
        console.log(this.files);
        if (this.files && this.files.length > 1) {
            fileName = (this.getAttribute('data-multiple-caption') || '').replace('{count}', this.files.length);
        }
        else {
            fileName = this.files[0].name;
        }

        if (fileName) {
            label.querySelector('span').innerHTML = fileName;
        }
        else {
            label.innerHTML = labelVal;
        }
    });
});