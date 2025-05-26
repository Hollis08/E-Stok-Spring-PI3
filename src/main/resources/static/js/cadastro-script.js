document.getElementById("formProduto").addEventListener("submit", function(e) {
            e.preventDefault();

            const produto = {
                codigo: document.getElementById("codigoProduto").value,
                nome: document.getElementById("nomeProduto").value,
                valor: document.getElementById("valorProduto").value,
                categoria: document.getElementById("categoriaProduto").value,
                validade: document.getElementById("validadeProduto").value,
                quantidade: document.getElementById("quantidadeProduto").value
            };

            fetch("http://localhost:3000/produtos", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(produto)
            })
            .then(function(response) {
                if (!response.ok) throw new Error("Erro na requisição");
                return response.json();
            })
            .then(function(data) {
                alert("Produto incluido com sucesso!");
                document.getElementById("formProduto").reset();
            })
            .catch(function(error) {
                console.error("Error: ", error);
                alert("Erro ao cadastrar produto.");
            });
        });