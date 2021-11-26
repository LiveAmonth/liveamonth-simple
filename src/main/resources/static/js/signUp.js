$(document).ready(function(){
    $('#showPassword').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-fw fa-eye-slash field-icon mt-3")
                .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-fw fa-eye field-icon mt-3")
                .prev('input').attr('type','password');
        }
    });
    $('#showCheckPassword').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-fw fa-eye-slash field-icon mt-1")
                .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-fw fa-eye field-icon mt-1")
                .prev('input').attr('type','password');
        }
    });
    $('#password-field').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-fw fa-eye-slash field-icon")
                .prev('label').prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-fw fa-eye field-icon")
                .prev('label').prev('input').attr('type','password');
        }
    });
});