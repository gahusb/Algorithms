//let fs = require('fs');
//let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
//let [N, M] = input.shift().split(' ')

let input = require('fs').readFileSync('./input_exam.txt').toString().trim().split('\n');

let count = input[0];
let numbers = [];

for (let i = 1; i < input.length; i++) {
    if (input[i] !== '') {
        numbers.push(input[i].split(' '));
    }
}

for (let i = 0; i < numbers.length; i++){
    let num1 = Number(numbers[i][0]);
    let num2 = Number(numbers[i][1]);

    console.log(num1 + num2);
}

function solution() {

}