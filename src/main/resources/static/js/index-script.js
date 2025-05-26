const urlParams = new URLSearchParams(window.location.search);
            const nome = urlParams.get('nome');

            document.getElementById('nome').textContent = nome;


            document.getElementById("formUsuario").addEventListener("submit", function(e) {
    e.preventDefault();

    const nome = document.getElementById("nome").value;
    const senha = document.getElementById("senha").value;

        fetch(`http://localhost:3000/usuarios?nome=${nome}&senha=${senha}`)
            .then(function(response) {
                if (!response.ok) throw new Error("Erro na requisição");
                return response.json();
            })
            .then(function(data) {
                if (data.length > 0) {
                    alert("Bem-vindo ao E-Stok, " + nome + "!");
                    window.location.href = `pagina-inicial.html?nome=${data[0].nome}`; 
                    console.log(data[0]);
                } else {
                    alert("Usuário ou senha inválidos");
                }
            })
            .catch(function(error) {
                console.error("Erro:", error);
                alert("Erro ao verificar login");
            });
        });