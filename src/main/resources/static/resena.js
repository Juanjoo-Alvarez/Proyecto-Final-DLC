document.addEventListener("DOMContentLoaded", function () {
    const stars = document.querySelectorAll(".star");
    const ratingInput = document.getElementById("rating");
    const form = document.getElementById("review-form");

    document.addEventListener("DOMContentLoaded", function () {
        const stars = document.querySelectorAll(".star");
        const ratingInput = document.getElementById("rating");
    
        // Agregar evento de clic a cada estrella
        stars.forEach(star => {
            star.addEventListener("click", () => {
                const ratingValue = parseInt(star.getAttribute("data-value"));
    
                // Actualizar la calificación en el campo oculto
                ratingInput.value = ratingValue;
    
                // Actualizar la visualización de las estrellas
                stars.forEach(s => {
                    if (parseInt(s.getAttribute("data-value")) <= ratingValue) {
                        s.classList.add("checked");
                    } else {
                        s.classList.remove("checked");
                    }
                });
            });
        });
    });
    

    // Manejo del envío del formulario
    form.addEventListener("submit", async (e) => {
        e.preventDefault(); // Prevenir recarga de la página

        const restaurantName = document.getElementById("restaurant-name").value;
        const rating = ratingInput.value;
        const reviewText = document.getElementById("review-text").value;

        if (!rating || !reviewText) {
            alert("Por favor, completa todos los campos antes de enviar.");
            return;
        }

        // Enviar datos al servidor
        try {
            const response = await fetch("/submit-review", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    restaurantName,
                    rating,
                    reviewText
                })
            });

            if (response.ok) {
                alert("Reseña enviada exitosamente.");
                window.location.href = "/mainPage"; // Redirigir a otra página si es necesario
            } else {
                alert("Error al enviar la reseña.");
            }
        } catch (error) {
            console.error("Error:", error);
            alert("Error al conectar con el servidor.");
        }
    });
});
