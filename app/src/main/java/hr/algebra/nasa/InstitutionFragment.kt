package hr.algebra.nasa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import hr.algebra.nasa.adapter.EmployeeAdapter
import hr.algebra.nasa.adapter.SubjectAdapter
import hr.algebra.nasa.adapter.ViewPagerAdapter
import hr.algebra.nasa.databinding.FragmentInstitutionBinding
import hr.algebra.nasa.model.Employee
import hr.algebra.nasa.model.Subject

class InstitutionFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding: FragmentInstitutionBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var employeeAdapter: EmployeeAdapter
    lateinit var subjectAdapter: SubjectAdapter
    lateinit var listImages: List<Int>
    private var listEmployee = ArrayList<Employee>()
    private var listSubject = ArrayList<Subject>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstitutionBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.idViewPager.findViewById<ViewPager>(R.id.idViewPager)
        fillImageList()

        viewPagerAdapter = ViewPagerAdapter(requireContext(), listImages)
        binding.idViewPager.adapter = viewPagerAdapter
        setEmployeesRecycleView()
        setSubjectRecycleView()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setEmployeesRecycleView() {
        binding.recycleView.findViewById<RecyclerView>(R.id.recycleView)
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        addDataToEmployeeRecycleView()
        employeeAdapter = EmployeeAdapter(listEmployee)
        binding.recycleView.adapter = employeeAdapter
    }

    private fun setSubjectRecycleView() {
        binding.recycleViewSubject.findViewById<RecyclerView>(R.id.recycleViewSubject)
        binding.recycleViewSubject.layoutManager = LinearLayoutManager(requireContext())
        addDataToSubjectRecycleView()
        subjectAdapter = SubjectAdapter(listSubject)
        binding.recycleViewSubject.adapter = subjectAdapter
    }

    private fun addDataToSubjectRecycleView() {
        listSubject.add(Subject("Programsko in??enjerstvo", "Po zavr??etku studija, imat ??e?? sva potrebna znanja o programskom in??enjerstvu, ovladat ??e?? glavnim objektno orijentiranim jezicima .NET i JAVA, nau??it ??e?? programirati, razvijati i odr??avati slo??ene aplikacije i informacijske sustave. U kojem god od ovih segmenata vidi?? svoju budu??nost, s Algebrinom diplomom joj zasigurno kre??e?? ususret s vjetrom u le??a."))
        listSubject.add(Subject("Sistemsko in??enjerstvo", "Po zavr??etku studija, znat ??e?? sve ??to je potrebno za primjenjivanje i odr??avanje slo??enih informacijskih sustava koji se zasnivaju na najsuvremenijoj tehnologiji dana??njice. Trogodi??nji stru??ni prijediplomski studij sistemskog in??enjerstva daje ti vje??tine i znanja pomo??u kojih ??e?? mo??i izgraditi karijeru u stvarnom svijetu IT sistemskog in??enjerstva bilo gdje u svijetu."))
        listSubject.add(Subject("Ra??unalna multimedija", "Po zavr??etku studija, znat ??e?? kako najbolje uklopiti medijske tehnologije u svaki projekt, te kako savladati nabolje prakse u stvaranju multimedijskog sadr??aja"))
        listSubject.add(Subject("Digitalni marketing", "Digitalni marketing sve vi??e postaje jedno od najtra??enijih podru??ja ekonomije, ??to zna??i da s diplomom iz digitalnog marketinga sigurno ne??e?? dugo tra??iti posao. Stru??ni prijediplomski studij digitalnog marketinga studentima omogu??uje niz prednosti"))
    }

    private fun addDataToEmployeeRecycleView() {
        listEmployee.add(Employee("Daniel Bele", R.drawable.dbele, "Predava??", "Daniel Bele, stru??.spec.ing.comp., ro??en je 1975. u Zagrebu. Zavr??io je diplomski studij programskog in??enjerstva na Visokom u??ili??tu Algebra. Prije i tijekom obrazovanja i rada stekao je Oracle (5), Microsoft (3), ATC (2) i Itil certifikate. Predava?? je i asistent je na Visokom u??ili??tu Algebra te nastavnik na Otvorenom u??ili??tu Algebra. Profesionalno se bavio programiranjem u trajanju od 10 godina, od ??ega je 8.5 godina proveo u tvrtci Interactive1. Radio je na brojnim projektima, prete??ito u Java tehnologiji, za englesko i talijansko tr??i??te. Na projektima se bavio WEB tehnologijom (client i server side) te Androidom. Zanosi se knji??evno????u te je izdao roman i zbirku pri??a. Bavio se i novinarstvom te je 2 godine bio kolumnist portala SEEbiz.eu, kao i radio voditelj emisije na Radio Trsat u Rijeci u trajanju od godinu dana."))
        listEmployee.add(Employee("Danijel Ku??ak", R.drawable.dkucak, "Predava??", "Danijel Ku??ak je ro??en 1978. godine u Zagrebu, gdje je i diplomirao na matemati??kom odsjeku Prirodoslovno-matemati??kog fakulteta. Trenutno poha??a doktorski studij Informacijskih znanosti na Fakultetu Organizacije i Informatike. 2006. godine asistirao je na kolegiju Informatika na Edukacijsko rehabilitacijskom fakultetu. Od 2007. godine do danas je zaposlen kao predava?? na Visokom U??ili??tu Algebra. Vi??estruki je dobitnik nagrade za najboljeg predava??a na Visokom U??ili??tu Algebra. U??a specijalnost mu je razvoj web aplikacija i web usluga temeljenih na platformama .NET (Web Forms i MVC.NET) i Java. Do sada je bio autor i koautor 5 knjiga na temu programiranja, a objavio je i desetak znanstvenih i stru??nih radova na temu razvoja aplikacija. Od zavr??etka studija do danas radi kao razvojni in??enjer ili arhitekt na nekoliko informacijskih sustava od kojih posebno isti??e: MyQTest ??? sustav za testiranje znanja, HAK e-ispiti ??? sustav za provo??enje testiranja poznavanja pravila sigurnosti prometa, MedicalBit ??? BIS sustav implementiran u klinici za plu??ne bolesti Rockfellerova Zagreb, CRIS (Croatian Road Inspection System) ??? sustav za podr??ku inspekcijskog nadzora cestovnog prometa."))
        listEmployee.add(Employee("Aleksandar Radovan", R.drawable.aradovan, "Predava??", "Aleksander Radovan je 2021. godine doktorirao na Fakultetu elektrotehnike i ra??unarstva u Zagrebu. Radi kao direktor razvoja u tvrtki BISS d.o.o., a osim toga radi kao predava?? na nekoliko veleu??ili??ta u Zagrebu i okolici na predmetima vezanim uz programski jezik Java i informacijske sustave op??enito. Osim toga obna??a funkciju predsjednika Odbora za edukaciju u Hrvatskoj udruzi Java korisnika (HUJAK) te sudjeluje u programskim odborima vezanim za organiziranje Java konferencija u Hrvatskoj. Objavio je vi??e od 60 stru??nih i znanstvenih radova vezanih uz programiranje u Javi i vezane tehnologije. Bavi se i podru??jem umjetne inteligencije, genetskih algoritama, robotike i podu??avanje programiranja mla??ih generacija"))
    }

    private fun fillImageList() {
        listImages = ArrayList<Int>()
        listImages = listImages + R.drawable.algebradruga
        listImages = listImages + R.drawable.algebrajedan
        listImages = listImages + R.drawable.algebratreca
        listImages = listImages + R.drawable.algebracetvrta
    }

    override fun onMapReady(googleMap: GoogleMap) {

    }
}