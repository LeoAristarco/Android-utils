public class unFragmentFragment extends BaseInternetConnectionErrorFragment {
    


    @Override
    protected View customOnCreateView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);
        return view;
    }

    @Override
    public void onReconnectionButtonClick() {
        // hacer la coneccion http
    }
}