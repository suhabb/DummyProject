/**
 * Created by suhail on 18/10/2015.
 */

var FORM={

    onSubmit:function(){
      $("form#formdata").submit();
    },

    onReset:function(){
        alert("reset");
        $("form#formdata").reset;
    }
};

$(document).ready(function() {

    $("#submit-id").click(function(){
        FORM.onSubmit();
    });

    $("#reset-id").click(function(){
        FORM.onReset();
    });

});


var LOGIN={
    "greeting":"hello",
    "wishes":"morning",
    yes:$("#id").append("Hello"),
    onClick:function(){
        return this.greeting+this.wishes;
    }

};

