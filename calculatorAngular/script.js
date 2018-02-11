var app = angular.module('app', []);

app.controller('CalculatorCtrl', function ($scope, Calculator) {
    $scope.operand1 = '';
    $scope.operand2 = '';
    $scope.operation = '';
    $scope.result = '';

    $scope.calculate = function (operation, operand1, operand2) {
        var sum = 0;
   
        var left = $scope.operand1;
        if (isNaN(left)) {
            left = 0;
        }
        left = parseFloat(left);

        var right = $scope.operand2;
        if (isNaN(right)) {
            right = 0;
        }
        right = parseFloat(right);

        switch($scope.operation){
            case '+': sum += Calculator.addition(left, right); break;
            case '-': sum += Calculator.subtraction(left, right); break;
            case '*': sum += Calculator.multiplication(left, right); break;
            case '/': sum += Calculator.division(left, right); break;
        }
        
        if (isNaN(sum)) {
            sum = '';
        }
        $scope.result = sum;
    };
});

app.service('Calculator', function () {

    this.addition = function (left, right) {
        return left + right;
    };

    this.subtraction = function (left, right) {
        return left - right;
    };

    this.multiplication = function (left, right) {
        return left * right;
    };

    this.division = function (left, right) {
        return left / right;
    };

});

app.directive('validOperator', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {

            function validateNumber(value) {
                var validity = !isNaN(value);
                ngModel.$setValidity('number', validity)
                return value;
            }

            ngModel.$parsers.push(validateNumber);
            ngModel.$formatters.push(validateNumber);
        }
    }
});