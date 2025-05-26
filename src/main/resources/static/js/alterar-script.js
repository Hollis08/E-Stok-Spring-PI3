
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');

        fetch(`http://localhost:3000/produtos/${id}`)
        .then(response => response.json())
        .then(produto => {
            document.getElementById('codigoProduto').value = produto.codigo,
            document.getElementById('nomeProduto').value = produto.nome,
            document.getElementById('valorProduto').value = produto.valor,
            document.getElementById('categoriaProduto').value = produto.categoria,
            document.getElementById('validadeProduto').value = produto.validade,
            document.getElementById('quantidadeProduto').value = produto.quantidade
        })
        .catch(error => console.error("Erro ao carregar", error))

        document.getElementById("formAlterar").addEventListener("submit", function(e) {
            e.preventDefault();

            const produtoAtt = {
                codigo: document.getElementById("codigoProduto").value,
                nome: document.getElementById("nomeProduto").value,
                valor: document.getElementById("valorProduto").value,
                categoria: document.getElementById("categoriaProduto").value,
                validade: document.getElementById("validadeProduto").value,
                quantidade: document.getElementById("quantidadeProduto").value
            };

            fetch(`http://localhost:3000/produtos/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(produtoAtt)
            })
            .then( response => {
                alert("Produto Atualizado com sucesso!");
                window.location.href="produto-lista.html";
            })
            .catch(function(error) {
                console.error("Error: ", error);
                alert("Erro ao atualizar produto");
            });
        });