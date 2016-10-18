/**
*  Module
*
* Description
*/
var app=angular.module('calculatorApp', []);
app.controller('CalculatorCntrl', CalculatorController);


function CalculatorController(){
	this.resultedValue=0;
	this.buttonClicked=function(button){
		this.selectedOperation=button;
	}
	this.computeResult=function(){
		var numberOne=parseFloat(this.op1);
		var numberTwo=parseFloat(this.op2);

		switch(this.selectedOperation){

			case '+': this.resultedValue=numberOne +numberTwo;
						break;

			case '-':this.resultedValue=numberOne -numberTwo;
						break;

			case '*': this.resultedValue=numberOne * numberTwo;
						break;

			case '/':this.resultedValue=numberOne / numberTwo;
						break;

		}
	}

}
