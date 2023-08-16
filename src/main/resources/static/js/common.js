function set_cookie(name, value, days) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + days);
    document.cookie = encodeURIComponent(name) + '=' + encodeURIComponent(value) + ';expires=' + exdate.toUTCString() + ';path=/';
}

//쿠키 값 가져오는 함수
function get_cookie(name) {
    var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
}

//쿠키 삭제하는 함수
function delete_cookie(name) {
    document.cookie = encodeURIComponent(name) + '=; expires=Thu, 01 JAN 1999 00:00:10 GMT';
}
