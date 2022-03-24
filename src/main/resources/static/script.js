const togglebutton = document.getElementsByClassName('toggle-button')[0]
const menubar = document.getElementsByClassName('menubar-links')[0]


var counter = 10;
var childWidth = document.getElementById("review-card-item1").offsetWidth;
/* const body = document.getElementsByTagName('body')[0] */


togglebutton.addEventListener('click', () => {
    menubar.classList.toggle('active')
})


/*Infinite Horizontal scroll for the reviews section*/
function checkEdge(event) {
    var parent = document.getElementById("review-cards");
    if ( parent.scrollLeft == parent.scrollWidth-parent.offsetWidth ) {
        //Detected scroll to the edge of the right
        counter = ((counter+1)%11);
        parent.appendChild(document.getElementById("review-card-item"+(counter+1))); 
        parent.scrollLeft -= childWidth;
    }
    
    if ( ! parent.scrollLeft ) {
        //Left edge
        counter = ((counter-1)%11);
        if ( counter == -2 ) counter = 9;
        parent.insertBefore((document.getElementById("review-card-item"+(counter+2))),parent.firstChild);
        parent.scrollLeft += childWidth;
    }
}
