package com.mycompany.bancoabc;

import java.util.*;

public class Banco {

    public static void main(String[] args) {

        String nombre;
        String cedula;
        String cuenta;
        String password;
        String continuar;
        String opcion;
        String operacion;
        float deposito;
        float retiro;
        float transferencia;
        String cuentaTransferencia;
        int contador1;
        int contador2;
        int contador3;
        int numeroCuenta = 106;

        Persona persona1 = new Persona("Juan Perez", "1085123456", "101");
        Persona persona2 = new Persona("Adrian Lopez", "1085654321", "102");
        Persona persona3 = new Persona("Juliana Maya", "1085012345", "103");
        Persona persona4 = new Persona("Monica Suarez", "1085543210", "104");
        Persona persona5 = new Persona("Juan Molina", "1085654789", "105");

        ArrayList<Persona> ListaPersona = new ArrayList<Persona>();//creamos el objeto lista
        ListaPersona.add(persona1);//almacenamos la persona en la lista
        ListaPersona.add(persona2);
        ListaPersona.add(persona3);
        ListaPersona.add(persona4);
        ListaPersona.add(persona5);

        Transaccion transaccion1 = new Transaccion("101", "password1", 250000);
        Transaccion transaccion2 = new Transaccion("102", "password2", 1200000);
        Transaccion transaccion3 = new Transaccion("103", "password3", 380000);
        Transaccion transaccion4 = new Transaccion("104", "password4", 3300000);
        Transaccion transaccion5 = new Transaccion("105", "password5", 3600000); 

        ArrayList<Transaccion> ListaTransaccion = new ArrayList<Transaccion>();//creamos el objeto lista
        ListaTransaccion.add(transaccion1);//almacenamos la persona en la lista
        ListaTransaccion.add(transaccion2);
        ListaTransaccion.add(transaccion3);
        ListaTransaccion.add(transaccion4);
        ListaTransaccion.add(transaccion5);

        Scanner guardar = new Scanner(System.in);

        do {

            System.out.println("\t\t =========BANCO ABC=============");
            System.out.println("\nBIENVENIDO AL CAJERO AUTOMATICO DEL BANCO ABC, SELECCIONE LA OPCIÓN QUE DESEE: \n\n");
            System.out.println("\t1 Registrarse en el banco\t2 Ingresar a cuenta personal ");
            opcion = guardar.nextLine();

            if ("1".equals(opcion)) {

                System.out.println("\nIngrese su nombre: ");
                nombre = guardar.nextLine();
                System.out.println("Ingrese su cédula: ");
                cedula = guardar.nextLine();
                System.out.println("Ingrese una contraseña: ");
                password = guardar.nextLine();

                ListaPersona.add(new Persona(nombre, cedula, String.valueOf(numeroCuenta)));
                ListaTransaccion.add(new Transaccion(String.valueOf(numeroCuenta), password, 0));

                System.out.println("\n\t\t----¡REGISTRO EXITOSO!----");
                ListaPersona.get(ListaPersona.size() - 1).info();
                ListaTransaccion.get(ListaTransaccion.size() - 1).info();

                numeroCuenta = numeroCuenta + 1;

            } else {
                if ("2".equals(opcion)) {
                    contador3 = 0;
                    System.out.println("\nIngrese el número de cuenta: ");
                    cuenta = guardar.nextLine();

                    for (int c = 0; c <= ListaPersona.size() - 1; c++) {
                        if ((cuenta.equals(ListaPersona.get(c).getCuenta()))) {
                            contador3 = 1;
                            for (int k = 1; k <= 3; k++) {
                                System.out.println("Ingrese la contraseña: ");
                                password = guardar.nextLine();
                                contador1 = 0;
                                contador2 = 0;

                                for (int i = 0; i <= ListaPersona.size() - 1; i++) {
                                    if ((cuenta.equals(ListaPersona.get(i).getCuenta())) && (password.equals(ListaTransaccion.get(i).getPassword()))) {
                                        contador2 = contador2 + 1;
                                        System.out.println("\n\t\tOPERACIÓN A REALIZAR:\n\t1 Consultar saldo\t\t2 Deposito\n\t3 Retiro\t\t\t4 Transacción");
                                        operacion = guardar.nextLine();

                                        switch (operacion) {
                                            case "1":
                                                ListaPersona.get(i).info();
                                                ListaTransaccion.get(i).info();
                                                break;
                                            case "2":
                                                System.out.println("\nINGRESE EL MONTO A DEPOSITAR EN SU CUENTA: ");
                                                deposito = Float.valueOf(guardar.nextLine());
                                                System.out.println("\n\t\tDEPOSITO EXITOSO.");
                                                System.out.println("\t" + ListaPersona.get(i).getNombre() + " su saldo ahora es: $" + ListaTransaccion.get(i).depositar(deposito));
                                                break;
                                            case "3":
                                                System.out.println("\nINGRESE EL MONTO A RETIRAR DE SU CUENTA: ");
                                                retiro = Float.valueOf(guardar.nextLine());
                                                if (retiro <= ListaTransaccion.get(i).getSaldo()) {
                                                    System.out.println("\n\t\tRETIRO EXITOSO.");
                                                    System.out.println("\t" + ListaPersona.get(i).getNombre() + " su saldo ahora es: $" + ListaTransaccion.get(i).retirar(retiro));
                                                } else {
                                                    System.out.println("\n\tERROR. EL SALDO ES INSUFICIENTE");
                                                }
                                                break;
                                            case "4":
                                                System.out.println("\nINGRESE EL MONTO A TRANSFERIR: ");
                                                transferencia = Float.valueOf(guardar.nextLine());

                                                if (transferencia <= ListaTransaccion.get(i).getSaldo()) {
                                                    System.out.println("INGRESE LA CUENTA A DONDE TRANSFERIR EL MONTO: ");
                                                    cuentaTransferencia = guardar.nextLine();

                                                    for (int j = 0; j <= ListaPersona.size() - 1; j++) {

                                                        if (cuentaTransferencia.equals(ListaTransaccion.get(j).getCuenta())) {
                                                            System.out.println("\n\t\tTRANSACCIÓN EXITOSA");
                                                            System.out.println("\t" + ListaPersona.get(i).getNombre() + " su saldo ahora es: $" + ListaTransaccion.get(i).transferir(transferencia));
                                                            ListaTransaccion.get(j).depositar(transferencia);
                                                            contador1 = contador1 + 1;
                                                        }

                                                    }
                                                    if (contador1 == 0) {
                                                        System.out.println("\nERROR. LA CUENTA NO EXISTE O EN SU DEFECTO HA SIDO BLOQUEADA.");
                                                    }

                                                } else {
                                                    System.out.println("\n\tERROR. EL SALDO ES INSUFICIENTE");
                                                }

                                                break;
                                            default:
                                                System.out.println("\nERROR. SELECCIONÓ UNA OPCIÓN INCORRECTA");
                                        }

                                    }
                                }
                                if (contador2 == 1) {
                                    break;
                                } else if ((contador2 == 0) && (k == 3)) {
                                    System.out.println("\nLA CUENTA " + cuenta + " HA SIDO BLOQUEADA. PARA MÁS INFORMACIÓN COMUNIQUESE CON UN ASESOR DE LA ENTIDAD FINANCIERA.");
                                    ListaPersona.remove(c);
                                    ListaTransaccion.remove(c);
                                    break;
                                } else {
                                    System.out.println("\n\tERROR. USUARIO " + ListaPersona.get(c).getNombre() + " CONTRASEÑA INCORRECTA. " + (k + 1) + "° Intento.");
                                }
                            }

                        }
                    }
                    if (contador3 == 0) {
                        System.out.println("\n\tERROR. EL USUARIO NO EXISTE O EN SU DEFECTO HA SIDO BLOQUEADO.");
                    }
                } else {
                    System.out.println("\n\nERROR. INGRESÓ UNA OPCIÓN INCORRECTA");
                }

            }
            System.out.println("\n\n\t\t---FIN DE LA SESIÓN---");

            System.out.println("\n\n¿Desea realizar una nueva operación? (Si-No): ");
            continuar = guardar.nextLine();
            System.out.println("\n\n\n\n");
        } while (("SI".equals(continuar)) || ("Si".equals(continuar)) || ("si".equals(continuar)) || ("S".equals(continuar)) || ("s".equals(continuar)));

        System.out.println("\t---HASTA LA PROXIMA. ¡GRACIAS POR UTILIZAR NUESTROS SERVICIOS!---");
        System.out.println("\n\n\n\n");

    }

}
