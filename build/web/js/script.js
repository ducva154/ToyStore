function openTabs(e, tabID) {
    var i;
    var content = document.getElementsByClassName("tab-contents");
    
    for (i = 0; i < content.length; i++) {
        content[i].style.display = 'none';
    }
    content[tabID].style.display = 'block';
    
}

