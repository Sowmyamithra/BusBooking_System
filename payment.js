function validate()
{
    var cno=document.payment.cardno;
    var chd=document.payment.cardholder;
    var cvv=document.payment.cvv;
    if(cno_validation(cno))
    {
        if(chd_validation(chd))
        {
            if(cvv_validation(cvv))
            {
		return true;
            }
        }
    }
    return false;
}
function cno_validation(cno)
{
    var cno_len=cno.value.length;
    if(cno_len!=16)
    {
        alert("Card number should contain 16 digits.");
        cno.focus();
        return false;
    }
    return true;
}
function chd_validation(chd)
{
    var chd_len=chd.value.length;
    if(chd_len<5)
    {
        alert("Card holder name should contain atleast 5 characters.");
        chd.focus();
        return false;
    }
    var letters = new RegExp("^[a-zA-Z]+$");
    if(letters.test(chd.value))
        return true;
    else
    {
        alert("Card holder name should contain alphabets only.");
        chd.focus();
        return false;
    }
}
function cvv_validation(cvv)
{
    var cvv_len=cvv.value.length;
    var letters = new RegExp("[0-9]{3}");
    if(letters.test(cvv.value))
    {
        if(cvv_len==3)
            return true;
        else
        {
            alert("Length should be 3");
            cvv.focus();
            return false;
        }
    }
    else
    {
        alert("Enter Number Type");
        cvv.focus();
        return false;
    }
}