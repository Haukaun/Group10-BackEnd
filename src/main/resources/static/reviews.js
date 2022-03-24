


function showForm(){
    document.getElementById('formElement').style.display = 'block';
}


function closeForm(){
    document.getElementById('formElement').style.display = 'none';
}


const submitButton = document.getElementById("formButton");
const list = document.getElementsByClassName("review-list")[0];


submitButton.addEventListener('click',()=>{
    let newLi = document.createElement('li');
    let newDiv = document.createElement('div');
    newDiv.className = "li-div";
    let newLabel = document.createElement('label');
    
    newLabel.innerText = document.getElementById('username').value;
    list.appendChild(newLi);
    newLi.appendChild(newDiv);
    newDiv.appendChild(newLabel)  
});