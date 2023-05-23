/**
 * 
 */
function generateForms() {
    var numItems = document.getElementById("num-items").value;
    var formsHTML = "";
    for (var i = 0; i < numItems; i++) {
      formsHTML += '<div class="menu-item"><label for="item-name-' + i + '">Item Name:</label><input type="text" id="item-name-' + i + '" name="item-name-' + i + '"><label for="item-price-' + i + '">Item Price:</label><input type="number" id="item-price-' + i + '" name="item-price-' + i + '"></div>';
    }
    formsHTML += '<button type="button" class="add-button">Add</button>';
    document.getElementById("menu-forms").innerHTML = formsHTML;
  }

