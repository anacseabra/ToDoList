
package com.example.todolist.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Importo a classe Todo e as tarefas de exemplo que criei
import com.example.todolist.domain.Todo
import com.example.todolist.domain.todo1
import com.example.todolist.domain.todo2
import com.example.todolist.domain.todo3
import com.example.todolist.ui.theme.ToDoListTheme

// Função responsável por montar o visual de uma única tarefa
@Composable
fun TodoItem(
    todo: Todo, // Recebe os dados da tarefa que quero exibir
    onCompletedChange: (Boolean) -> Unit,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier // Permite personalizar o visual por fora
) {
    Surface(
        onClick = onItemClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium, // Usa o formato de borda do tema
        shadowElevation = 2.dp, // Adiciona uma sombra para destacar o cartão
        border = BorderStroke(
            width = 1.dp, // Espessura da borda
            color = MaterialTheme.colorScheme.outline // Cor da borda do tema
        )
    ) {
        // Organiza os elementos lado a lado, na horizontal
        Row(
            modifier = Modifier
                .padding(16.dp), // Cria um espaço interno ao redor dos elementos
            verticalAlignment = Alignment.CenterVertically // Centraliza tudo na vertical
        ) {
            // Checkbox que representa se a tarefa foi concluída
            Checkbox(
                checked = todo.isCompleted, onCheckedChange = onCompletedChange
            )

            // Cria um espaço de 8 dp entre o checkbox e o texto
            Spacer(modifier = Modifier.width(8.dp))

            // Agrupa o título e a descrição, um abaixo do outro
            Column(
                modifier = Modifier
                    .weight(1f), // Ocupa o espaço disponível entre os elementos da Row
            ) {
                Text(
                    text = todo.title, // Mostra o título da tarefa recebida
                    style = MaterialTheme.typography.titleLarge, // Estilo de título do tema
                )

                // Só mostra a descrição se ela não for null
                todo.description?.let {
                    Text(
                        text = it, // Aqui, it representa o valor da descrição
                    )
                }
            }

            // Cria um espaço entre os textos e o botão de excluir
            Spacer(modifier = Modifier.width(8.dp))

            // Botão que futuramente poderá excluir a tarefa
            IconButton(
                onClick = onDeleteClick
            ) {
                Icon(
                    imageVector = Icons.Default.Delete, // Ícone de lixeira
                    contentDescription = "Delete", // Descrição para acessibilidade
                )
            }
        }
    }
}

// Preview para visualizar a tarefa 1 dentro do Android Studio
@Preview
@Composable
private fun TodoItemPreview1() {
    ToDoListTheme() {
        TodoItem(
            todo = todo1, // Passa a primeira tarefa de exemplo
            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {},
        )
    }
}

// Preview para visualizar a tarefa 2
@Preview
@Composable
private fun TodoItemPreview2() {
    ToDoListTheme() {
        TodoItem(
            todo = todo2, // Passa a segunda tarefa de exemplo
            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {},
        )
    }
}

// Preview para visualizar a tarefa 3
@Preview
@Composable
private fun TodoItemPreview3() {
    ToDoListTheme() {
        TodoItem(
            todo = todo3, // Passa a terceira tarefa de exemplo
            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {},
        )
    }
}
