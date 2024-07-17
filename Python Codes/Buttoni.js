javascript:(function(){
    
    var selector = prompt('Enter the button selector (e.g., ".button-class"):');

    if(selector){
        var button = document.querySelector(selector);

    if(button){
        button.style.position = 'fixed'; // Example of styling the button
        button.style.bottom = '20px';
        button.style.right = '20px';
        button.style.backgroundColor = '#007BFF';
        button.style.color = 'white';
        button.style.padding = '15px 30px';
        button.style.border = 'none';
        button.style.borderRadius = '50px';
        button.style.fontSize = '18px';
        button.style.cursor = 'pointer';
        button.style.boxShadow = '0 4px 8px rgba(0, 0, 0, 0.2)';
        button.style.transition = 'transform 0.3s ease';

        button.addEventListner('mouseover', function(){
          button.style.transform = 'scale(1.1)';
    });

    button.addEventListner('mouseout', function(){
        button.style.transform = 'scale(1)';
    });

    alert('Button found! You can now interact with it.');

    document.addEventListener('keydown', function(event) {
        if (event.altKey && event.key === 'b') {  // Use 'Alt + B' as the shortcut
            button.focus();
            button.click();
        }
    });
    }else{
        alert('Button not found!');

    }
}
    else {
        alert('No selector provided.');
    }

})();