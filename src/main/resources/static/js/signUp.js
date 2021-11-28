$(document).ready(function(){
    $('#password-check-field').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-fw fa-eye-slash field-icon")
                .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-fw fa-eye field-icon")
                .prev('input').attr('type','password');
        }
    });
    $('#password-field').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-fw fa-eye-slash field-icon")
                .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-fw fa-eye field-icon")
                .prev('input').attr('type','password');
        }
    })
});