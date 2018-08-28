// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    let usaEle = document.querySelector("span[data-customAttr = 'USA']");
    console.log(usaEle.innerHTML);
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
    for (counter = 0; counter < document.getElementsByTagName("td").length; counter++ ) {
        let text = document.getElementsByTagName("td")[counter];
        if (text.innerHTML === "Sales") {
            let employee = document.getElementsByTagName("td")[counter - 1];
            console.log(employee.innerHTML);
        }
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
    let anchors = document.getElementsByTagName('a');

    for (counter = 0; counter < anchors.length; counter++) {
        for (counter2 = 0; counter2 < anchors[counter].childNodes.length; counter2++) {
            if (anchors[counter].childNodes[counter2].tagName === 'SPAN') {
                console.log(anchors[counter].childNodes[counter2].innerHTML);
            }
        }
    }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies() {
    let selector = document.querySelector("select[name='skills']");
    let options = selector.querySelectorAll("option[selected='selected']");

    options.forEach(element => {
        console.log(element.getAttribute("value") + " " + element.innerHTML);
        } ) ;
    }

    // 5. Custom Attribute
    // Define function getCustomAttribute()
    // Find all elements with "data-customAttr" attribute
    // Print the value of the attribute.
    // Print the element that has the attribute.

function getCustomAttribute() {
    let customs = document.querySelectorAll("[data-customAttr]");

    customs.forEach(element => {
        console.log(element.getAttribute("data-customAttr"));
        console.log(element);
    });
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

document.getElementById('num1').onchange = function() {updateSum()};
document.getElementById('num2').onchange = function() {updateSum()};

  function updateSum() {
    let first = document.getElementById('num1');
    let second = document.getElementById('num2');

    let firstAsNum = (Number(first.value) );
    let secondAsNum = (Number(second.value) );
    let result = firstAsNum + secondAsNum;

    if (result === NaN) {
        document.getElementById('sum').innerHTML = "Cannot add";
    } else {
        document.getElementById('sum').innerHTML = result;
    }
  }

//   7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

document.querySelector("select[name='skills']").onchange = function() {skillAlert()};

function skillAlert() {
    let selector = document.querySelector("select[name='skills']");
    let selectedOption = selector.value;
    console.log("Are you certain you wish to select " + selectedOption + " as a skill?");
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

document.getElementById("firstForm").onchange = function() {colorChange()};

let firstColor = "No favorite color";
let secondColor = "No favorite color";

function colorChange() {
    let colors = document.getElementsByName("favoriteColor");

    colors.forEach(currColor => {
        if (currColor.checked) {
            if (firstColor !== currColor.value) {
                secondColor = firstColor;
                firstColor = currColor.value;
                colors.forEach(colorEle => {
                    colorEle.style.color = firstColor;
                });
                alert(`So you like ${firstColor} more than ${secondColor} now?`);
            }  
        }
    });
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
//     Show the name if hidden.
    

let employees = document.getElementsByClassName("empName");

for (counter = 0; counter < employees.length; counter++) {
    employees[counter].onmouseover = function() {hideShow(event)};
};

function hideShow() {
    let callingEmp = event.target;
    if (callingEmp.style.opacity !== "0") {
        callingEmp.style.opacity = 0;
    }
    else {
        callingEmp.style.opacity = 1;
    }
}

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

function refreshTime(){
    let refresh=1000; 
    mytime = setTimeout('displayClock()', refresh);
    }
    
function displayClock() {
    let currentTime = new Date()
    document.getElementById('currentTime').innerHTML = formatAMPM(currentTime);
    refreshTime();
     }

function formatAMPM(date) {
        let hours = date.getHours();
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        let ampm = hours >= 12 ? 'pm' : 'am';
        hours = hours % 12;
        hours = hours ? hours : 12;
        minutes = minutes < 10 ? '0' + minutes : minutes;
        seconds = seconds < 10 ? '0' + seconds : seconds;
        let timeString = hours + ':' + minutes + ':' + seconds + ' ' + ampm;
        return timeString;
    }

displayClock();

