function configCheckBox(){
    let checkbox = document.getElementsByClassName("ckbox");
    let tam = checkbox.length;
    console.log(tam);
    for (var i=0; i< tam; i++){
      addEventListnerToBox(checkbox[i], checkbox);

    }
}
function addToDOM(parentElement, id){
    console.log("ADD");
    newInput = document.createElement("input");
    newInput.setAttribute("name", "idsTopico[]");
    newInput.type = "hidden";
    newInput.className = "idTopico";
    newInput.value = id;
    newInput.id="idTopico"+id;
    document.getElementById('btn-remover').removeAttribute("disabled");
    parentElement.appendChild(newInput);
}

function removeFromDOM(parentElement, element){
    document.getElementById('idTopico'+element.name).remove();
    if (checkIfChangeButton()){
        document.getElementById('btn-remover').setAttribute("disabled", "disabled");
    }
}

function addEventListnerToBox(box, checkbox){
    box.addEventListener("change", function(event, checkbox){
        if(event.currentTarget.checked){
            addToDOM(document.getElementById("remover-topico"), event.currentTarget.name);
        }else{
            removeFromDOM(document.getElementById("remover-topico"), event.currentTarget);
        }
    });
}

window.addEventListener("load", function(){
    configCheckBox();
});

function checkIfChangeButton(){
    let toCheck = document.getElementsByClassName("ckbox");
    let tam = toCheck.length;
    console.log(tam);
    for (var i=0; i< tam; i++){
      if(toCheck[i].checked){
          return false;
      }
    }
    return true;
}

