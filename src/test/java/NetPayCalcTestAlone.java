import org.junit.Test;

public class NetPayCalcTestAlone {

    @Test
    public void netPayCalc() {
        NetPayCalc netPayC=new NetPayCalc();
        System.out.print(netPayC.netPayCalc(3,150,16,71));
    }
}