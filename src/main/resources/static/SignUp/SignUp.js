const container = document.querySelector('.container');
const signupForm = document.getElementById('signup_form');

const value1 = document.getElementById('value1');
const value2 = document.getElementById('value2');
const value3 = document.getElementById('value3');
const value4 = document.getElementById('value4');
const value5 = document.getElementById('value5');

const inputNm = document.getElementById('inputNm');
const inputId = document.getElementById('inputId');
const inputPw = document.getElementById('inputPw');
const inputPw_confirm = document.getElementById('inputPw_confirm');
const inputPn = document.getElementById('inputPn');

signupForm.addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault();
    }
});

inputNm.addEventListener('keyup', function(event) {
    if (event.key === 'Enter' && inputNm.value.trim() !== "") {
        setTimeout(function() {
            inputId.focus();
        }, 10);

        setTimeout(function() {
            container.scrollTop = container.scrollHeight;
        }, 50);
    }
});

inputId.addEventListener('keyup', function(event) {
    if (event.key === 'Enter' && inputId.value.trim() !== "") {
        value3.classList.remove('hidden');

        setTimeout(function() {
            inputPw.focus();
        }, 10);

        setTimeout(function() {
            container.scrollTop = container.scrollHeight;
        }, 50);
    }

    // if (event.key === 'Backspace' && inputId.value === "") {
    //     setTimeout(function() {
    //         inputNm.focus();
    //     }, 10);
    // }
});

inputPw.addEventListener('keyup', function(event) {
    if (event.key === 'Enter' && inputPw.value.trim() !== "") {
        value4.classList.remove('hidden');

        setTimeout(function() {
            inputPw_confirm.focus();
        }, 10);

        setTimeout(function() {
            container.scrollTop = container.scrollHeight;
        }, 50);
    }

    // if (event.key === 'Backspace' && inputPw.value === "") {
    //     value3.classList.add('hidden');
    //     setTimeout(function() {
    //         inputId.focus();
    //     }, 10);
    // }
});

inputPw_confirm.addEventListener('keyup', function(event) {
    if (event.key === 'Enter' && inputPw_confirm.value.trim() !== "") {
        value5.classList.remove('hidden');

        setTimeout(function() {
            inputPn.focus();
        }, 10);

        setTimeout(function() {
            container.scrollTop = container.scrollHeight;
        }, 50);
    }

    // if (event.key === 'Backspace' && inputPw_confirm.value === "") {
    //     value4.classList.add('hidden');
    //     setTimeout(function() {
    //         inputPw.focus();
    //     }, 10);
    // }
});

// inputPn.addEventListener('keyup', function(event) {
//     if (event.key === 'Backspace' && inputPn.value === "") {
//         value5.classList.add('hidden');
//         setTimeout(function() {
//             inputPw_confirm.focus();
//         }, 10);
//     }
// });



const hidePw = document.getElementById('hidePw');
const seePw = document.getElementById('seePw');
const hidePw_confirm = document.getElementById('hidePw_confirm');
const seePw_confirm = document.getElementById('seePw_confirm');

hidePw.addEventListener('click', function() {
    inputPw.type = 'text';
    hidePw.classList.add('hidden');
    seePw.classList.remove('hidden');
});

seePw.addEventListener('click', function() {
    inputPw.type = 'password';
    seePw.classList.add('hidden');
    hidePw.classList.remove('hidden');
});


hidePw_confirm.addEventListener('click', function() {
    inputPw_confirm.type = 'text';
    hidePw_confirm.classList.add('hidden');
    seePw_confirm.classList.remove('hidden');
});

seePw_confirm.addEventListener('click', function() {
    inputPw_confirm.type = 'password';
    seePw_confirm.classList.add('hidden');
    hidePw_confirm.classList.remove('hidden');
});