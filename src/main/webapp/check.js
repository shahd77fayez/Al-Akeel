/**
 * 
 */
const form = document.getElementById("myForm");
const submitButton = document.getElementById("submitButton");

form.addEventListener("submit", function(event) {
  if (!form.checkValidity()) {
    event.preventDefault(); // Prevent the form from submitting if it's invalid
  }
});

submitButton.addEventListener("click", function(event) {
  event.preventDefault(); // Prevent the button from submitting the form
  form.reportValidity(); // Display the validation message if the form is invalid
  if (form.checkValidity()) {
    form.submit(); // Submit the form if it's valid
  }
});
function submitForm() {
    const form = document.getElementById("myForm");
    if (form.checkValidity()) {
      form.submit();
    } else {
      form.reportValidity();
    }
  }