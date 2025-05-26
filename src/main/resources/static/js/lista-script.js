fetch("http://localhost:3000/produtos")
        .then(response => response.json())
        .then(produtos => {
            const lista = document.getElementById("produtos");
            lista.innerHTML = produtos.map(produto => `
                <div class="list-group-item mb-3">    
                    <table class="table table-bordered">
          <thead class="thead-light">
            <tr>
              <th>Código:</th>
              <th>Nome:</th>
              <th>Valor:</th>
              <th>Categoria:</th>
              <th>Validade:</th>
              <th>Quantidade:</th>
              <th>Opções:</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${produto.codigo}</td>
              <td>${produto.nome}</td>
              <td>R$ ${produto.valor}</td>
              <td>${produto.categoria}</td>
              <td>${produto.validade}</td>
              <td>${produto.quantidade}</td>
              <td>
                <a href="produto-alterar.html?id=${produto.id}" class="btn btn-primary">Alterar</a>
                <button onclick="excluirProduto(${produto.id})" class="btn btn-danger">Excluir</button>
              </td>
            </tr>
          </tbody>
        </table>
                </div>
                
            `).join("");
        })
        .catch(error => console.error("Erro:", error));

        function excluirProduto(id){
            if(confirm("Deseja realmente excluir este Produto?")){
                fetch(`http://localhost:3000/produtos/${id}`,{
                    method: "DELETE"
                })
                .then(() => location.reload())
                .catch(error => console.error("Error" + error));
            }
        }