    document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById('numberForm');
    const resultsDiv = document.getElementById('results');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const numbers = document.getElementById('numbers').value.split(',').map(Number);

        const response = await fetch('/process-numbers', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(numbers)
        });
        const data = await response.text();
        resultsDiv.innerHTML = `<div class="result-box"><h3>Tree Created</h3><pre>${data}</pre></div>`;
    });

    showPreviousBtn.addEventListener('click', async () => {
        const response = await fetch('/previous-trees');
        const trees = await response.json();
        resultsDiv.innerHTML = trees.map(tree => `
            <div class="result-box">
                <h3>Input: ${tree.inputNumbers}</h3>
                <pre>${tree.treeStructure}</pre>
            </div>`).join('');
    });
});