const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');
const signInButton = document.getElementById('sign-in-btn');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

signInButton.addEventListener('click', () => {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

//     // Datos de login quemados
// if ((email === 'riv24856@uvg.edu.gt' && password === '123456789') ||
//     (email === 'nav24044@uvg.edu.gt' && password === '123456789') ||
//     (email === 'pen24997@uvg.edu.gt' && password === '123456789')) {
//     // Redirigir a la página de restaurantes
//     window.location.href = './persona-list.html';
// } else {
// alert('Correo o contraseña incorrectos');
// }

});
