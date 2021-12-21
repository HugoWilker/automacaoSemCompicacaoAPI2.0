package transferencia;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.BreakIterator;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {

         xuxa = new Cliente("Xuxa","12345678900","1234567");
         silvioSantos = new Cliente ("Silvio Santos", "98765432100","7654321");

         contaXuxa = new Conta("0025", "2254", 2500.00, xuxa );
         contaSilvio = new Conta ("0026","2251", 3500.00,silvioSantos );

    }

    @Test
    public void realizartransacao(){

        contaXuxa.realizarTransferencia(1000.00, contaSilvio);
        assertEquals(1500.00,contaXuxa.getSaldo());
        assertEquals(4500.00,contaSilvio.getSaldo());

        System.out.println(contaSilvio.getSaldo());
        System.out.println(contaXuxa.getSaldo());

    }

    @Test
    public void validarTransferenciaInvalida(){


        //Cliente xuxa = new Cliente("Xuxa","12345678900","1234567");
        //Cliente silvioSantos = new Cliente ("Silvio Santos", "98765432100","7654321");

        //Conta contaXuxa = new Conta("0025", "2254", 2500.00, xuxa );
        //Conta contasilvio = new Conta ("0026","2251", 3500.00,silvioSantos );


        boolean resultado = contaXuxa.realizarTransferencia( 3500.00, contaSilvio);

        assertFalse(resultado);


        System.out.println(resultado);

    }

    @Test
      public void validarPropietario(){

        assertEquals(silvioSantos, contaSilvio.getPropietario());


    }

  @Test
     public void validarNumeroConta () {

          assertEquals("2251", contaSilvio.getNumeroConta());

    }

    @Test
    public void validarAgencia(){

        assertEquals( "0026", contaSilvio.getAgencia());
    }

@Test
  public void ValidarNome(){

        assertEquals("Silvio Santos", silvioSantos.getNome());
  }

  @Test
  public void validarCPF(){

        assertEquals("98765432100", silvioSantos.getCpf());
  }


 @Test
  public void validarRG(){

    assertEquals("7654321", silvioSantos.getRg());

    }

}