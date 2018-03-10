package burrows.apps.example.gif.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import test.TestBase

class RiffsyResponseDtoTest : TestBase() {
  companion object {
    private val TEST_RESULTS = arrayListOf<ResultDto>()
  }
  private var sut = RiffsyResponseDto(results = TEST_RESULTS, next = DOUBLE_RANDOM)

  @Test fun testGetResults() {
    assertThat(sut.results).isEqualTo(TEST_RESULTS)
  }

  @Test fun testGetNext() {
    assertThat(sut.next).isEqualTo(DOUBLE_RANDOM)
  }
}
