import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMCGUI extends JFrame {
    private JTextField textFieldPeso;
    private JTextField textFieldAltura;
    private JButton buttonCalcular;
    private JLabel labelResultado;

    public CalculadoraIMCGUI() {
        setTitle("Calculadora IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        JLabel labelPeso = new JLabel("Peso (kg):");
        textFieldPeso = new JTextField(10);
        JLabel labelAltura = new JLabel("Altura (m):");
        textFieldAltura = new JTextField(10);
        buttonCalcular = new JButton("Calcular");
        labelResultado = new JLabel();

        add(labelPeso);
        add(textFieldPeso);
        add(labelAltura);
        add(textFieldAltura);
        add(buttonCalcular);
        add(labelResultado);

        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(textFieldPeso.getText());
            double altura = Double.parseDouble(textFieldAltura.getText());
            double imc = peso / (altura * altura);

            String classificacao;
            if (imc < 18.5) {
                classificacao = "Abaixo do Peso";
            } else if (imc < 24.9) {
                classificacao = "Peso Normal";
            } else if (imc < 29.9) {
                classificacao = "Sobrepeso";
            } else if (imc < 34.9) {
                classificacao = "Obesidade Grau I";
            } else if (imc < 39.9) {
                classificacao = "Obesidade Grau II";
            } else {
                classificacao = "Obesidade Grau III";
            }

            labelResultado.setText("IMC = " + imc + ", Classificação: " + classificacao);
        } catch (NumberFormatException ex) {
            labelResultado.setText("Erro: Insira valores válidos para peso e altura.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraIMCGUI().setVisible(true);
            }
        });
    }
}
