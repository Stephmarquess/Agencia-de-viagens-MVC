function cpfMask() {
    const cpfInput = document.getElementById('cpf')
    let cpfInputLength = cpfInput.value.length
    if (cpfInputLength === 3 || cpfInputLength === 7) {
        cpfInput.value += '.'
    } else if(cpfInputLength === 11) {
        cpfInput.value += '-'
    }
}

function confirmaDestino() {
        
var confirma = confirm("Ao deletar o destino todas as reservas a ele associadas serão excluídas. Você tem certeza que deseja excluir este destino?");

if (confirma) {
} else { alert("Deleção cancelada");
	}
 }
 
 function confirmaCliente() {
        
var confirma = confirm("Ao deletar o Cliente todas as reservas a ele associadas serão excluídas. Você tem certeza que deseja excluir este cliente?");

if (confirma) {
} else { alert("Deleção cancelada");
	}
 }
 
 
 function confirmaReserva() {
        
var confirma = confirm("Você tem certeza que deseja excluir esta Reserva?");

if (confirma) {
} else { alert("Deleção cancelada");
	}
 }