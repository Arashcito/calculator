// Handle calculation form
const form = document.getElementById('calc-form');
const resultDiv = document.getElementById('result');

form.addEventListener('submit', async function(e) {
    e.preventDefault();
    const operand1 = parseFloat(document.getElementById('operand1').value);
    const operand2 = parseFloat(document.getElementById('operand2').value);
    const operation = document.getElementById('operation').value;

    const response = await fetch('/calculator/calculate', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ operand1, operand2, operation })
    });
    const data = await response.json();
    if (data.success) {
        resultDiv.textContent = `Result: ${data.result}`;
    } else {
        resultDiv.textContent = `Error: ${data.error}`;
    }
});

// Handle square root
const sqrtBtn = document.getElementById('sqrt-btn');
sqrtBtn.addEventListener('click', async function() {
    const operand = parseFloat(document.getElementById('operand1').value);
    const response = await fetch(`/calculator/sqrt?operand=${operand}`, {
        method: 'POST'
    });
    const data = await response.json();
    if (data.success) {
        resultDiv.textContent = `Square Root: ${data.result}`;
    } else {
        resultDiv.textContent = `Error: ${data.error}`;
    }
});

// Handle percentage
const percentBtn = document.getElementById('percent-btn');
percentBtn.addEventListener('click', async function() {
    const operand = parseFloat(document.getElementById('operand1').value);
    const response = await fetch(`/calculator/percentage?operand=${operand}`, {
        method: 'POST'
    });
    const data = await response.json();
    if (data.success) {
        resultDiv.textContent = `Percentage: ${data.result}`;
    } else {
        resultDiv.textContent = `Error: ${data.error}`;
    }
});
