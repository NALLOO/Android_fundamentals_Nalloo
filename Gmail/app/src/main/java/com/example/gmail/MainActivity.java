package com.example.gmail;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Inbox> inboxList = new LinkedList<>();
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private InboxAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();


        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new InboxAdapter(this, inboxList);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);

        setSupportActionBar(toolbar);
    }

    private void addData() {
        inboxList.add(new Inbox("GitHub", "[GitHub] A personal access token has been added to your account", "A personal access token (update assignment) with gist, read:org, repo, and workflow scopes was recently added to your account. Visit https://github.com/settings/tokens for more information.To see this and other security events for your account, visit https://github.com/settings/security-log  If you run into problems, please contact support by visiting https://github.com/contactThanks,The GitHub Team", "4:00 PM", false));
        inboxList.add(new Inbox("Codeforces", "Codeforces Round 798 (Div. 2)", "I'm glad to invite you to take part in Codeforces Round 798 (Div. 2). It starts on Friday, June, 10, 2022 16:35 (UTC). The contest duration is 2 hours. The allowed programming languages are C/C++, Pascal, Perl, Java, C#, Python (2 and 3), Ruby, PHP, Haskell, Scala, OCaml, D, Go, JavaScript and Kotlin", "May 30", false));
        inboxList.add(new Inbox("Spotify", "Premium, miễn phí trong 1 tháng. Chúng tôi đang muốn trao đi.", "Tải xuống playlist của bạn và nghe offline để tiết kiệm dung lượng. Tận hưởng tính năng bỏ qua không giới hạn, ngay cả trên thiết bị di động, và tìm kiếm những gì bạn muốn nghe. Ngoài ra, nghe bản nhạc bất kỳ bạn muốn trên mọi thiết bị với tính năng nghe nhạc theo yêu cầu. Và nghe tất cả nhạc của bạn không quảng cáo, để bạn có thể thoải mái thưởng thức mà không bị gián đoạn.", "May 28", true));
        inboxList.add(new Inbox("Dribbble ", "Get more eyes on your portfolio", "Experience limitless creation solutions and design freely on a fully-customizable canvas. Simplify the feedback process with integrated collaboration tools, all backed by infrastructure trusted for performance, reliability and security.", "May 20", false));
        inboxList.add(new Inbox("Baemin", "[BAEMIN] Vui lòng xác nhận địa chỉ email của bạn", "Hãy nhấn nút dưới để xác thực email nhé!", "May 1", true));
        inboxList.add(new Inbox("Figma", "Forgot your password?", "To reset your password, click the button below. The link will self-destruct after three days.", "Apr 28", true));
        inboxList.add(new Inbox("MoMo ", "Thiết lập thanh toán thành công cho dịch vụ Gojek", "Chào PHẠM ĐÌNH NGHĨA,Bạn đã thiết lập thành công Ví MoMo 0961***201 để thanh toán dịch vụ Gojek. Từ nay, các thanh toán cho dịch vụ Gojek sẽ được tự động trừ tiền qua các tài khoản thanh toán trong Ví MoMo của bạn.", "Apr 20", false));
        inboxList.add(new Inbox("Discord ", "Important policy updates coming to Discord ",
                "Hey there,Some important changes are coming to Discord: we’re updating our Terms of Service, Privacy Policy, and Community Guidelines.", "Apr 15", false));
    }

}