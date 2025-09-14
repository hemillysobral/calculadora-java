function appendNumber(num) {
  const display = document.getElementById('display');
  display.value = display.value + num;
}

function appendOperator(op) {
  const display = document.getElementById('display');
  display.value = display.value + op;
}

function clearDisplay() {
  document.getElementById('display').value = '';
}

function calculateResult() {
  const expression = document.getElementById('display').value;

  fetch('/api/calcular', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ expressao: expression })
  })
  .then(response => response.json())
  .then(data => {
    document.getElementById('display').value = data.resultado;
  })
  .catch(() => {
    document.getElementById('display').value = 'Erro';
  });
}
