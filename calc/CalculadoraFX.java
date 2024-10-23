package calculadora.calc;

import javafx.application.Application; // base para a aplicação
import javafx.scene.Scene; // área de exibição
import javafx.scene.control.Button; // botões
import javafx.scene.control.TextField; // caixas de texto
import javafx.scene.layout.GridPane; // grade de telas
import javafx.stage.Stage; // janela principal

public class CalculadoraFX extends Application {
    private TextField Texto; // caixa de texto para exibir o resultado e números
    private double numero1, numero2, resultado; // variáveis
    private String operacao; // operador
    private boolean operacaoSelecionada = false; // flag para verificar se uma operação foi selecionada

    @Override
    public void start(Stage primaryStage) {
        Texto = new TextField(); // cria a caixa de texto
        Texto.setEditable(false); // desabilita a edição da caixa de texto

        // cria a grade
        GridPane layout = new GridPane();
        layout.add(Texto, 0, 0, 4, 1); // adiciona a caixa de texto na grade na posição (0,0), ocupando 4 colunas e 1 linha

        // array com os botões da calculadora
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C" // botão de Clear
        };

        // adiciona os botões
        int index = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (index < botoes.length) { // Verifica se o índice está dentro do limite do array
                    Button botao = new Button(botoes[index]); // cria o botão
                    botao.setMinSize(60, 60); // define o tamanho do botão
                    botao.setOnAction(e -> processButton(botao.getText())); // faz com que o botão recolha o texto
                    layout.add(botao, j, i); // adiciona o botão na grade
                    index++; // avança para o próximo botão
                }
            }
        }

        Scene scene = new Scene(layout, 240, 250); // cria a cena com layout 'layout' e de tamanho 240x250
        primaryStage.setTitle("Calculadora"); // título da janela
        primaryStage.setScene(scene); // adiciona a cena na janela
        primaryStage.show(); // mostra a janela na tela
    }

    private void processButton(String text) {
        if (text.equals("C")) {
            Texto.clear(); // limpa o campo de texto
            operacaoSelecionada = false; // reseta a flag
        } else if (text.equals("=")) {
            if (operacaoSelecionada) {
                numero2 = Double.parseDouble(Texto.getText()); // pega o segundo número
                calcular(); // chama o método de cálculo
                operacaoSelecionada = false; // reseta a flag
            }
        } else if ("+-*/".contains(text)) {
            if (!operacaoSelecionada) {
                numero1 = Double.parseDouble(Texto.getText()); // pega o primeiro número
                operacao = text; // armazena a operação
                operacaoSelecionada = true; // marca que uma operação foi selecionada
                Texto.clear(); // limpa a caixa de texto para o próximo número
            }
        } else {
            Texto.appendText(text); // adiciona o botão pressionado ao campo de texto
        }
    }

    private void calcular() {
        switch (operacao) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    Texto.setText("Erro"); // tratamento de divisão por zero
                    return;
                }
                break;
        }
        Texto.setText(Double.toString(resultado)); // converte o resultado para string e coloca no campo de texto
    }

    public static void main(String[] args) {
        launch(args); // chama o método de inicialização (start)
    }
}