import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero {

    public static void main(String[] args) {
        // Creamos los objetos para leer teclado y generar números aleatorios
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        // El sistema genera un número aleatorio entre 1 y 100
        int numeroSecreto = random.nextInt(100) + 1;
        int intentosMaximos = 7;
        int intentosRealizados = 0;
        int numeroUsuario = 0;
        boolean haAdivinado = false;

        System.out.println("==================================================");
        System.out.println("   ¡BIENVENIDO AL JUEGO: ADIVINA EL NÚMERO!       ");
        System.out.println("==================================================");
        System.out.println("He pensado un número entre 1 y 100.");
        System.out.println("Tienes " + intentosMaximos + " intentos para adivinarlo.\n");

        // Bucle principal del juego
        while (intentosRealizados < intentosMaximos && !haAdivinado) {
            intentosRealizados++;
            System.out.print("Intento " + intentosRealizados + "/" + intentosMaximos + " - Introduce tu número: ");
            
            // Validación básica para evitar fallos si no meten un entero
            if (teclado.hasNextInt()) {
                numeroUsuario = teclado.nextInt();

                if (numeroUsuario == numeroSecreto) {
                    haAdivinado = true;
                } else if (numeroUsuario < numeroSecreto) {
                    System.out.println("-> El número secreto es MAYOR.\n");
                } else {
                    System.out.println("-> El número secreto es MENOR.\n");
                }
            } else {
                System.out.println("-> ¡Por favor, introduce un número válido!\n");
                teclado.next(); // Limpiar el buffer del scanner
            }
        }

        // Mensaje final según el resultado
        System.out.println("--------------------------------------------------");
        if (haAdivinado) {
            System.out.println("¡ENHORABUENA! ¡Has acertado el número " + numeroSecreto + " en " + intentosRealizados + " intentos!");
        } else {
            System.out.println("¡GAME OVER! Has agotado tus intentos. El número era: " + numeroSecreto);
        }
        System.out.println("--------------------------------------------------");

        // Cerramos el scanner al terminar
        teclado.close();
    }
}