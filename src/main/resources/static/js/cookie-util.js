function setCookie(name, value, days){
    let expires = "";
    if (days){
        const data = new Date();
        data.setTime(data.getTime() + days * 24 * 60 * 60 * 1000);
        expires = "; expires=" + data.toUTCString();
    }
    document.cookie = name + "=" + encodeURIComponent(value) + expires + "; path=/";
}

function getCookie(name){
    const nameEQ = name + "=";
    const ca = document.cookie.split(";");
    for (let i = 0; i < ca.length; i++){
        let c = ca[i].trim();
        if (c.indexOf(nameEQ) === 0) 
            return decodeURIComponent(c.substring(nameEQ.length));
    }
    return null;
}

function deleteCookie(name){
    document.cookie = name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}