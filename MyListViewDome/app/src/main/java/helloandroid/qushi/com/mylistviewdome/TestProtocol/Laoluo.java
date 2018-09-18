package helloandroid.qushi.com.mylistviewdome.TestProtocol;

public class Laoluo implements LLLProtocol {
    @Override
    public void submit() {
        System.out.println("申请：西门子冰箱质量缺陷，特此申请民事仲裁！");

    }

    @Override
    public void burden() {
        System.out.println("证据：这是购买冰箱的发票，以及冰箱质量问题的视频！");

    }

    @Override
    public void defend() {
        System.out.println("辩护：我们证据确凿，必须得到应该的赔偿！");

    }

    @Override
    public void finish() {
        System.out.println("诉讼完成：判决西门子北京分公司在七日之内退还老罗购买冰箱的成本！");

    }

    @Override
    public String baifen() {
        return "ccccccccccc";
    }
}
