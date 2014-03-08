package client1;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client1 
{
    public static void main(String []args) throws IOException
        {
        int porta_serv=2000;
        String Host="localhost";
        String Echo="";
        do
   {
         try 
         {
            Socket s=new Socket(Host,porta_serv);
            InputStream Input = s.getInputStream(); 
            DataInputStream Datainput = new DataInputStream(Input);
            OutputStream Output = s.getOutputStream(); 
            DataOutputStream Dataouput = new DataOutputStream(Output);
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(input);
            System.out.print("\n frase da inviare: ");
            String testo = buffer.readLine();
            Dataouput.writeUTF(testo);
            Echo=Datainput.readUTF();
            System.out.println("Il server risponde "+Echo);
        }
	 catch (UnknownHostException e) 
	{
              System.err.println(e);
        }
	 catch (IOException e) 
	{
            System.out.println("errore");
        }
   }
while(!Echo.equals("fine"));
        }
}
